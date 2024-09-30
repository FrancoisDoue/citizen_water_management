import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";
import axios from "axios";

export const login = createAsyncThunk("authentication/login", async () => {
    const response = await axios.post(`${BASE_URL}`);
    const data = await response.data;
    
    //TODO Manipuler Token
})



const authSlice = createSlice({
    name: "authentication",
    initialState: {       
        loginIsPending: false
    },
    reducers: {
        
    },
    extraReducers: (builder) => {
        builder.addCase(login.fulfilled, (state, action) => {
            // state.pokemons = action.payload.list;
            // state.next = action.payload.next;
            // state.previous = action.payload.previous;   
            state.loginIsPending = false         
        });
        
        builder.addCase(login.pending, (state, action) => {
            state.loginIsPending = true;
        })
    }
})

export default authSlice.reducer;