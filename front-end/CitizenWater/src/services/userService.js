import { createAsyncThunk } from "@reduxjs/toolkit";
import { api } from "../utils/api.backend";
import { setDatas } from "../store/userSlice";

export const fetchUserDatas = createAsyncThunk(
    'user/fetchUserDatas',
    async (_args, {rejectWithValue, getState, dispatch}) => {
        try {
            const {token, decodedToken} = getState().auth
            const response = await api.get(`/user/${decodedToken.id}`, {
                headers: {Authorization: `Bearer ${token}`}
            })
            dispatch(setDatas(response))
        } catch (e) {
            console.warn(e)
            rejectWithValue(e)
        }
    },
    {condition: (_args, {getState}) => !getState().users?.datas}
)