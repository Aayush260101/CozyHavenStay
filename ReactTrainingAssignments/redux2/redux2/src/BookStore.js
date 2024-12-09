import { configureStore } from "@reduxjs/toolkit";
import reducer from "./BookSlice1.js"
export const configStore = configureStore({reducer})