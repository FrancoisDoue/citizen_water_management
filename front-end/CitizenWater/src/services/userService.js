import { createAsyncThunk } from "@reduxjs/toolkit";
import { api } from "../utils/api.backend";

export const fetchUserDatas = createAsyncThunk(
    'user/fetchUserDatas',
    async (_args, {rejectWithValue, getState}) => {
        try {
            console.log('test')
            const {token, decodedToken} = getState().auth
            const response = await api.get(`/user/${decodedToken.id}`, {
                headers: {Authorization: `Bearer ${token}`}
            })
            console.log(response)
        } catch (e) {
            console.warn(e)
            rejectWithValue(e)
        }
    },
    {condition: (_, {getState}) => !getState().users?.datas}
)