import { createSlice } from "@reduxjs/toolkit";

const Books = createSlice({name:"Books",initialState:{DSA:200,JAVA:100,JavaScript:300,DBMS:120,OS:60},reducers:{
    issuebook(state,action){
        state[action.payload.bookName]-=parseInt(action.payload.quantity);
    },
    returnbook(state,action){
        state[action.payload.bookName]+=parseInt(action.payload.quantity);
    }
}})

export default Books.reducer;
export const {issuebook,returnbook} = Books.actions;