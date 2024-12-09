import React from 'react'
import "./App.css"

import {
  CardMeta,
  CardHeader,
  CardDescription,
  CardContent,
  Card,
  Icon,
  Image,
} from 'semantic-ui-react'

const Pcard = (props) => (

  <Card>
    <Image src={props.image} wrapped ui={false} />
    <CardContent>
      <CardHeader>Matthew</CardHeader>
      <CardMeta>
        <span className='date'>{props.price}</span>
      </CardMeta>
      <CardDescription>
        {props.description}
      </CardDescription>
    </CardContent>
    <CardContent extra>
      <a>
        <Icon name='user' />
        {props.title}
      </a>
    </CardContent>
    <button onClick={props.deleteProduct}>Delete</button>
    <button onClick={props.updateProduct}>Update</button>
  </Card>
  
  
)

export default Pcard