import React, { Component } from 'react'

export default class App extends Component {
  constructor(props)
  {
    super(props)
    this.state={c:0}
  }

  add=()=>{
    if(this.state.c<10)
    this.setState({c:this.state.c+1})
    else{
      this.setState({c:1})
    }
  }

  subtract=()=>{
    if(this.state.c>1)
    this.setState({c:this.state.c-1})
  else{
    this.setState({c:10})
  }
  }



  render() {
    return (<>
      <div> {this.state.c}</div>
      <button onClick={this.add}>Add</button>
      <button onClick={this.subtract}>Subtract</button>
      </>)
  }
}
