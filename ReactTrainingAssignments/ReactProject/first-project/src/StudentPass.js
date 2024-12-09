import React from 'react';
import "./App.css";

const StudentPass = ({ name, avg }) => {
    const gradeobtained = () => {
        if (avg >= 90) return 'A';
        else if (avg >= 80) return 'B';
        else return 'C';
    };

    return (
        <div className="div1">
            <h1>StudentPass</h1>
            <h1>Welcome {name}</h1>
            <h1>Total Marks {avg * 5}</h1>
            <h1>Grade {gradeobtained()}</h1> 
        </div>
    );
};

export default StudentPass;
