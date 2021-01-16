import React from 'react';
function Student(){
    const deleting = (id) => {
        console.log(document.getElementById(id))
        document.getElementById(id).remove();
        ;
    };
    return (
        <div>
            <table cellpadding='5' cellspacing='5' border='5px'>
            <thead>
                <th>ID</th>
                <th>Name</th>
                <th>Department</th>
                <th></th>
            </thead>
            <tbody>
            <tr id='1'>
                <td>001</td>
                <td>Ravi</td>
                <td>CSE</td>
                <td><button onClick={()=>deleting('1')}>x</button></td>
            </tr>
            <tr id='2'>
                <td>002</td>
                <td>Vijay</td>
                <td>IT</td>
                <td><button onClick={()=>deleting('2')}>x</button></td>
            </tr>
            </tbody>
            </table>
        </div>
    );
}
export default Student;