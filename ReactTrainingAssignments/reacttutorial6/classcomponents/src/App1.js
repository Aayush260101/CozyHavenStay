import { Component } from "react"
import Test from "./Test"
 
 
class App1 extends Component
{
 
constructor(props)
{
  super(props)
 
 
  this.state={c:0}
 
  console.log("i am constructor ")
 
 
 
}
 
add=()=>
{
  this.setState({c:3})
}
 
 
  componentDidMount=()=>
  {
    // fetch("api")
    console.log(" i am  did mounting ")
  }
 
  componentDidUpdate=()=>
  {
    console.log("i am component did update")
  }
 
  render()
  {
 
    console.log("i am render")
    return(<>
   
      <button onClick={this.add}> change </button>
      {
       this.state.c==0? <Test/>: null
  }
   
    </>)
  }
 
}
export default App1;
