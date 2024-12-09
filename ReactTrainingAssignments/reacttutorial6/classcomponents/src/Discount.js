import React, { Component } from 'react'

export class Discount extends Component {

    constructor(props){
        super(props);
        this.state={price:0,quantity:0,discount:0}
    }

    caldiscount=()=>{
        this.setState({discount:0.1*this.state.price*this.state.quantity})
    }

  render() {
    return (
      <div>
        <input type="text" placeholder="Enter Price" onChange={(e)=>this.setState({price:parseFloat(e.target.value)})}/>
        <input type="text" placeholder="Enter Quantity" onChange={(e)=>this.setState({quantity:parseInt(e.target.value)})}/>
        <button onClick={this.caldiscount}>Calculate</button>
        <h1>Total Amount : {this.state.price*this.state.quantity}</h1>
        <h1>Discount : {this.state.discount}</h1>
        <h1>Total Paid : {this.state.price*this.state.quantity-this.state.discount}</h1>
      </div>
    )
  }
}

export default Discount