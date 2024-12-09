import React, { useContext, useState } from 'react'
import { WebSeriesContext } from './WebContext';


const WebForm = () => {
    const {setWebSeries}=useContext(WebSeriesContext);
    const [series,setSeries] = useState("");
    const [seasons,setSeasons] = useState(0);

    
    const combine = ()=>{
        setWebSeries({series,seasons});
    }
  return (
    <div>Series Form
        <input type="text" placeholder="Enter Name of Series" onChange={(e)=>setSeries(e.target.value)}/>
        <input type="text" placeholder="Enter Seasons" onChange={(e)=>setSeasons(e.target.value)}/>
        <button onClick={combine}>OK</button>
    </div>
  )
}

export default WebForm