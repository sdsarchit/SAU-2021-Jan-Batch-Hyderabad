const arr=[1,2,3,4,5,6,7,8,9];
let Reduce=(arr,func,initial)=>{
    let final=initial;
    for(let element of arr){
        final=func(final,element);
    }
    return final;
}
alert(Reduce(arr,(val1,val2)=>val1+val2,0));