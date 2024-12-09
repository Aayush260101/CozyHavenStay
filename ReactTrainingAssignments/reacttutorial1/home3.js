const signup=()=>{
    let user=document.getElementById("t1").value;
    let pass=document.getElementById("t2").value;
    localStorage.setItem(user,pass);
}

const signin=()=>{
    let u=document.getElementById("t1").value;
    let p=document.getElementById("t2").value;
    if(localStorage.getItem(u)!= null)
    {
        if(localStorage.getItem(u)==p)
            alert("Welcome");
        else
        alert("Invalid Password");
    }
    else
    alert("Invalid Username");
}