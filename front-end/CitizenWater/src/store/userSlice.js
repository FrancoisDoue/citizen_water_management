import { createSlice } from "@reduxjs/toolkit";
import { fetchUserDatas } from "../services/userService";

const userSlice = createSlice({
    name: "user",
    initialState : {
        datas: null,
        pending: false,
    },
    reducers: {
        setDatas: (state, actions) => {
            console.log(actions.payload)
            state.datas = actions.payload
        },
        clearUserDatas: (state) => {
            console.log('clear user datas')
            state.datas = null
        }
    },
    extraReducers: ({addCase}) => {
        addCase(fetchUserDatas.fulfilled, (state, action) => {
            console.log('fetchuserdatas fullfilled')
            state.pending = false
        })
        addCase(fetchUserDatas.pending, (state, action) => {
            state.pending = true
        })
        addCase(fetchUserDatas.rejected, (state, action) => {
            console.log(action.error)
            console.log('reject')
            state.pending = false
        })
        // addMatcher(({type}) => type.endsWith('/fulfilled'), (state, action) => {
        //     state.pending = false
        // })
        // addMatcher(({type}) => type.endsWith('/rejected'), (state, action) => {
        //     console.log(action.error)
        //     state.pending = false
        // })
        // addMatcher(({type}) => type.endsWith('/pending'), (state, action) => {
        //     state.pending = true
        // })
    }
})

export const {
    setDatas,
    clearUserDatas,
} = userSlice.actions

export default userSlice.reducer;