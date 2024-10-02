import { createSlice } from "@reduxjs/toolkit";
import { login } from "../services/authService";

const authSlice = createSlice({
    name: "auth",
    initialState: {       
        token: null,
        decodedToken: null,
        pending: false,
    },
    reducers: {
        setToken: (state, action) => {
            console.log(action.payload)
            state.token = action.payload
        },
        setDecodedToken: (state, action) => {
            console.log(action.payload)
            state.decodedToken = action.payload
        },
        clearTokens: (state) => {
            state.token = null
            state.decodedToken = null
        }
    },
    extraReducers: (builder) => {
        builder.addCase(login.fulfilled, (state, action) => {
            state.pending = false
        });
        builder.addCase(login.pending, (state, action) => {
            state.pending = false         
        })
        builder.addCase(login.rejected, (state, action) => {
            state.pending = true;
            console.log(action.error)
        })
    }
})

export const selectIsLogged = ({auth}) => {
    return auth.token 
        && auth.decodedToken 
        && auth.decodedToken?.exp >= Math.round(Date.now() / 1000)
}

export const {
    setToken,
    setDecodedToken,
    clearTokens,
} = authSlice.actions;

export default authSlice.reducer;