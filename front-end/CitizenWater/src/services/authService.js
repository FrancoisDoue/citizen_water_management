import { createAsyncThunk } from "@reduxjs/toolkit";
import { api } from "../utils/api.backend";
import { jwtDecode } from "jwt-decode";
import { clearTokens, setDecodedToken, setToken } from "../store/authSlice";
import AsyncStorage from "@react-native-async-storage/async-storage";

const USER_KEY = 'citizen_water_token'

export const login = createAsyncThunk(
    'auth/login',
    async (credentials, {rejectWithValue, dispatch}) => {
        try {
            console.log('on auth/login' , credentials)
            const token = (await api.post('/auth/login', credentials)).token
            dispatch(setToken(token))
            dispatch(setDecodedToken(jwtDecode(token)))
            await AsyncStorage.setItem(USER_KEY, token)
        } catch (e) {
            console.log(e)
            rejectWithValue(e)
        }
    }
)

export const logout = createAsyncThunk(
    'auth/logout',
    (_arg, {dispatch}) => {
        AsyncStorage.removeItem(USER_KEY).then(() => dispatch(clearTokens()))
    }
)

export const initAuth = createAsyncThunk(
    'auth/initAuth',
    async (_arg, {dispatch}) => {
        const token = await AsyncStorage.getItem(USER_KEY)
        if (!!token) {
            const decodedToken = jwtDecode(token)
            if (decodedToken?.exp >= Math.round(Date.now() / 1000)) {
                dispatch(setToken(token))
                dispatch(setDecodedToken(decodedToken))
            } else {
                AsyncStorage.removeItem(USER_KEY)
            }
        }
    }
)