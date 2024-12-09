import { configureStore } from "@reduxjs/toolkit";
 
import reducer from "./BookSlice.js"
export const configstore=configureStore({reducer})