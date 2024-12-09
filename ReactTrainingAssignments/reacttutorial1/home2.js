const products = [
    {
        name: "dsa",
        price: 100,
        qty: 10,
        city: ["Pune", "Delhi"],
        manufacturer: { name: "ABC Manufacturing", city: "Mumbai" }
    },
    {
        name: "java",
        price: 200,
        qty: 5,
        city: ["Pune", "Delhi"],
        manufacturer: { name: "ABC Manufacturing", city: "Mumbai" }
    },
    {
        name: "react",
        price: 150,
        qty: 8,
        city: ["Pune", "Delhi"],
        manufacturer: { name: "ABC Manufacturing", city: "Mumbai" }
    },
    {
        name: "mongodb",
        price: 250,
        qty: 3,
        city: ["Pune", "Delhi"],
        manufacturer: { name: "ABC Manufacturing", city: "Mumbai" }
    }
];

const booksales=()=>{
    let a=document.getElementById("t1").value;
    let b=parseInt(document.getElementById("t2").value);
    let flag=0;
    for(let i=0;i<products.length;i++){
        if(a==products[i].name)
        {
            flag=1;
            if(b<=products[i].qty){
                amt=b*products[i].price;
                finalamt=amt-(0.05*amt);
                alert(finalamt);
            }
            else
            alert("Not enough Quantity");
        }
        
        
    }
    if(flag==0)
        alert("Book not found");
}