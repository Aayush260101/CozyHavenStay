import React, { createContext, useState } from 'react'

export const WebSeriesContext = createContext();

const WebContext = ({children}) => {
    const [webSeries,setWebSeries] = useState({series:"",seasons:0});
  return (
    <div>
        <WebSeriesContext.Provider value={{webSeries,setWebSeries}}>
            {children}
        </WebSeriesContext.Provider>
    </div>
  )
}

export default WebContext