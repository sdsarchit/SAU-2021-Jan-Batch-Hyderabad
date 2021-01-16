import React, { useState } from 'react';
function Bottle(){
    const [v1,setName1]=useState();
    const [v2,setName2]=useState();
    const [result,setName]=useState('');
    const onChangeBottleName = () => {
    setName(Number(v1)+Number(v2));
  };
    return (<div>
        <input onChange={(e)=>{setName1(e.target.value)}}></input>
        <p></p>
        <input onChange={(e)=>{setName2(e.target.value)}}></input>
        <button onClick={onChangeBottleName}>Add</button>
        <p>{result}</p>
    </div>);
}
export default Bottle;