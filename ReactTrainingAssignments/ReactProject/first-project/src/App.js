
import './App.css';
import Card from './Card';

import { useEffect, useState } from 'react';

const App=()=>{
  let [search,setSearch]=useState("");
  let [fheroes,setFheroes]=useState([]);

  

  useEffect(()=>setFheroes(heroes.filter((t)=>t.name.includes(search))),[search]);

  
  let heroes=[{name:"Thor",age:"1500",img1:"../Thor.png"},{name:"Captain America",age:"150",img1:"../CapAmerica.jpg"},
    {name:"Iron Man" ,age:"45", img1:"../ironman.png"},{name:"Bucky" ,age:"148" ,img1:"../bucky.png"},
    {name:"HawkEye", age:"52", img1:"../hawkeye.png"},{name:"Venom", age:"500", img1:"../venom.png"},
    {name:"SpiderMan", age:"24", img1:"../Spiderman.png"}
  ]
  
  return (<>
    <input className="search-box" type="text" placeholder="Search by name" onChange={(e)=>setSearch(e.target.value)}></input>
    <div className="main">
      
      {
      search.length>0?
      fheroes.map((hero) => <Card name={hero.name} age={hero.age} pic={hero.img1}/>)
      :
      heroes.map((hero) => 
        <Card name={hero.name} age={hero.age} pic={hero.img1} />
      )}
    </div>
    </>
  );
};



export default App;

