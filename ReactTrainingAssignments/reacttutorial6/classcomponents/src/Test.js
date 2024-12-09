import { Component } from "react"
 
 
class Test extends Component
{
 
constructor(props)
{
  super(props)
 
 
  this.state={c:0}
 
  console.log("i am constructor ")
 
 
 
}
 
 
 
  componentWillUnmount=()=>
  {
    console.log("i am component un mounting")
  }
 
  render()
  {
 
   
    return(<>
   
      <h1> TEST EXAMPLE </h1>
   
   
    </>)
  }
 
}
export default Test;
 
