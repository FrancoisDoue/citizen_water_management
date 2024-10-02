import axios from "axios";
import { BASE_URL } from "./constants";

const baseInterceptor = [
    (response) => response.data,
    (error) => Promise.reject({
        code: error.code,
        status: error.response?.status,
        url: error.response?.config.url,
        message: error.message,
    })
]

export const api = axios.create({baseURL : BASE_URL, timeout: 2000, })
api.interceptors.response.use(...baseInterceptor)
