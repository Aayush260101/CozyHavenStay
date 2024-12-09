import React from 'react'
import {
  CardMeta,
  CardHeader,
  CardDescription,
  CardContent,
  Card,
  Icon,
  Image,
} from 'semantic-ui-react'

const BCard = (props) => (
  <Card>
    <Image src={props.bookImage} wrapped ui={false} />
    <CardContent>
      <CardHeader>{props.bookTitle}</CardHeader>
      <CardMeta>
        <span className='date'>{props.bookAuthor}</span>
      </CardMeta>
      <CardDescription>
        {props.bookDescription}
      </CardDescription>
    </CardContent> 
    <button onClick={props.deleteBook}>Delete</button>
  </Card>
)

export default BCard