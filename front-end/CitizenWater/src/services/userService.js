import { createAsyncThunk } from "@reduxjs/toolkit";
import { api } from "../utils/api.backend";
import { setDatas } from "../store/userSlice";

export const fetchUserDatas = createAsyncThunk(
    'user/fetchUserDatas',
    (_args, {rejectWithValue, getState, dispatch}) => {
        const {token, decodedToken} = getState().auth
        return api.get(`/user/${decodedToken.id}`, { headers: {Authorization: `Bearer ${token}`} })
        .then((datas) => dispatch(setDatas(datas)))
        .catch(rejectWithValue)
    },
    {condition: (args, {getState}) => getState().user?.datas || !args?.force}
)