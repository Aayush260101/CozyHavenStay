import React, { useContext } from 'react'
import { WebSeriesContext } from './WebContext';


const WebDetails = () => {
    const {webSeries} = useContext(WebSeriesContext);
  return (
    <div>
        <h1>Series : {webSeries.series}</h1>
        <h1>Seasons : {webSeries.seasons}</h1>
    </div>
  )
}

export default WebDetails