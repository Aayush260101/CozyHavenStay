import { createSlice } from "@reduxjs/toolkit";
 
const Book=createSlice({name:"book",initialState:{dsa:5,java:90},reducers:{
 
 
 
 
    buyDSABk(state)
    {
       state.dsa=state.dsa-1
    }
    ,
    returnDSABk(state)
    {
       state.dsa=state.dsa+1
    }
   ,
    buyDSABkN(state,action)
    {
       state.dsa=state.dsa-action.payload
    }
    ,
 
    returnDSABkN(state,action)
    {
       state.dsa=state.dsa+parseInt(action.payload)
    },
    
    buyjavaBk(state)
    {
       state.java=state.java-1
    }
    ,
    returnjavaBk(state)
    {
        state.java=state.java+1
    }
   ,
    buyjavaBkN(state,action)
    {
       state.java=state.java-action.payload
    }
    ,
 
    returnjavaBkN(state,action)
    {
       state.java=state.java+parseInt(action.payload)
    }
 
 
 
}})
export default Book.reducer;
 
export const {buyDSABk,returnDSABk,buyDSABkN,returnDSABkN,buyjavaBk,returnjavaBk,buyjavaBkN,returnjavaBkN}=Book.actions