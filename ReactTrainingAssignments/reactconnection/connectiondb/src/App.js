import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";
import axios from "axios";
 
function App() {
  let [name, setName] = useState("");
  let [role, setRole] = useState("");
  let [email, setMail] = useState("");
  let [Password, setPassword] = useState("");
  let [title, setTitle] = useState("");
  let [pyear,setPyear] = useState();
  let [author,setAuthor] = useState("");
  let [book,setBook] = useState([]);
  let [isbn,setIsbn] = useState();
  let [newtitle,setNewtitle] = useState("");
  let [getbyisbn,setGetbyisbn] = useState();
  
 
  const signup = () => {
    console.log("Signup initiated");
    let user = {
      email,
      password: Password,
      name,
      userRole: role,
    };
    console.log("Payload to API:", user);
 
    axios
      .post("http://localhost:9000/api/auth/signup", user)
      .then(() => alert("User added"))
      .catch((e) => {
        if (e.response) {
          console.error("Response error:", e.response.data, e.response.status);
        } else {
          console.error("Request error:", e.message);
        }
      });
  };
 
  const signin = () => {
    let login = { email, password: Password };
    axios
      .post("http://localhost:9000/api/auth/login", login)
      .then((res) => {
        let token = res.data.jwt;
 
        localStorage.setItem("token", token);
      })
      .catch((e) => console.log(e));
  };

  const addbook = () => {
    console.log("Addbook initiated");
    let book = { title,author,publicationYear:pyear};
    let token=localStorage.getItem("token");
     
    
 
    axios
      .post("http://localhost:9000/api/admin/addNewBook", book,{
        headers:{
          Authorization: `Bearer ${token}`,
          'content-Type':  "application/json"
        }
      })
      .then(() => alert("Book added"))
      .catch((err)=>console.log(err));
  };

  const showall = () => {
    console.log("Getbook initiated");
    
    let token=localStorage.getItem("token");
    
 
    axios
      .get("http://localhost:9000/api/admin/getBooks",{
        headers:{
          Authorization: `Bearer ${token}`,
          
        }
      })
      .then((res)=>setBook(res.data))
      .catch((err)=>console.log(err));
  };


  const deletebook = () => {
    console.log("Deletebook initiated");
    
    let token=localStorage.getItem("token");
    
 
    axios
      .delete(`http://localhost:9000/api/admin/removeBook/${isbn}`,{
        headers:{
          Authorization: `Bearer ${token}`,
          
        }
      })
      .then((res)=>console.log("book removed"))
      .catch((err)=>console.log(err));
  };

  const updatebook = () => {
    console.log("Updatebook initiated");
    
    let token=localStorage.getItem("token");
    
 
    axios
      .put(`http://localhost:9000/api/admin/updateBook/${isbn}/${newtitle}`,{},{
        headers:{
          Authorization: `Bearer ${token}`,
          
        }
      })
      .then((res)=>console.log("book updated"))
      .catch((err)=>console.log(err));
  };

  const showbyid = () => {
    console.log("Getbookbyid initiated");
    
    let token=localStorage.getItem("token");
    
 
    axios
      .get(`http://localhost:9000/api/admin/getBookById/${isbn}`,{
        headers:{
          Authorization: `Bearer ${token}`,
          
        }
      })
      .then((res) => {
        console.log("Response from API:", res.data); 
        setGetbyisbn(res.data);
      })
      .catch((err)=>console.log(err));
  };

  
 
  return (<>
    <div className="cont">
      <br />
      <br />
      <input
        type="text"
        placeholder="Enter name"
        onChange={(e) => setName(e.target.value)}
      />
      <br />
      <input
        type="text"
        placeholder="Enter email"
        onChange={(e) => setMail(e.target.value)}
      />
      <br />
      <br />
      <input
        type="password"
        placeholder="Enter password"
        onChange={(e) => setPassword(e.target.value)}
      />
      <br />
      <input
        type="number"
        placeholder="Enter Role: Admin(0), User(1)"
        onChange={(e) => setRole(e.target.value)}
      />
      <br />
      <br />
      <button onClick={signup}>Sign up</button>
 
      <button onClick={signin}>Sign In</button>
    </div>
    <div className="cont">
    <br />
    <br />
    <input
      type="text"
      placeholder="Enter title"
      onChange={(e) => setTitle(e.target.value)}
    />

<br />
    <br />
    <input
      type="text"
      placeholder="Enter year"
      onChange={(e) => setPyear(e.target.value)}
    />

<br />
    <br />
    <input
      type="text"
      placeholder="Enter author"
      onChange={(e) => setAuthor(e.target.value)}
    />

<br />
 
  <button onClick={addbook}> Add book </button>
  <button onClick={showall}> Show Books </button>
    </div>

    <input type="text" placeholder="Enter isbn to del" onChange={(e)=>setIsbn(e.target.value)}/>
    <button onClick={deletebook}>Delete</button> <br/>

    <input type="text" placeholder="Enter isbn to update" onChange={(e)=>setIsbn(e.target.value)}/>
    <input type="text" placeholder="Enter updated title" onChange={(e)=>setNewtitle(e.target.value)}/>
    <button onClick={updatebook}>Update</button><br/>

    <input type="text" placeholder="Enter isbn to get" onChange={(e)=>setIsbn(e.target.value)}/>
    <button onClick={showbyid}>Get</button> <br/>
    
    
    {getbyisbn && (
  <div>
    <h1>Title: {getbyisbn.title}</h1>
    <h2>Author: {getbyisbn.author}</h2>
    <h3>Publication Year: {getbyisbn.publicationYear}</h3>
  </div>
)}
    
    



    {book.map((temp)=><h1>{temp.title}</h1>)}
    </>
  );
}
 
export default App;