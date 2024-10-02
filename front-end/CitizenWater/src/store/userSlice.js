import { createSlice } from "@reduxjs/toolkit";
import { fetchUserDatas } from "../services/userService";

const userSlice = createSlice({
    name: "user",
    initialState : {
        datas: null,
        isPending: false
    },
    reducers: {
        setDatas: (state, actions) => {

        },
    },
    extraReducers: (builder) => {
        builder.addCase(fetchUserDatas.fulfilled, (state, action) => {
            console.log('fetchuserdatas fullfilled')
            state.isPending = false
        })
        builder.addCase(fetchUserDatas.pending, (state, action) => {
            console.log('fetchuserdatas pending')

            state.isPending = true
        })
        builder.addCase(fetchUserDatas.rejected, (state, action) => {
            state.isPending = false
        })
    }
})

export const {
    setDatas
} = userSlice.actions

export default userSlice.reducer;