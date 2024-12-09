users=["user1","user2","user3","user4"];
passwords=["pass1","pass2","pass3","pass4"];
let flag=0;

const authenticate=()=>{
    let a=document.getElementById("t1").value;
    let b=document.getElementById("t2").value;
    for(let i=0;i<users.length;i=i+1){
        if(users[i]==a && passwords[i]==b){
            flag=1;
            break;
        }
            
        console.log(a,b,flag);
    }
    if(flag==1)
        alert("welcome")
    else
    alert("invalid")
    
}