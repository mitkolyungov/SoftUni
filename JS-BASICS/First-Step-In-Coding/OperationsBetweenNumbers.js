function calculateOperation(input){
    let n1 = Number(input[0]);
    let n2 = Number(input[1]);
    let op = [input[2]];

    let result = 0;

    if(op=="+"){
        result= n1+n2;
        if(result%2==0){
            console.log(`${n1} + ${n2} = ${result} - even`);
        }else{
            console.log(`${n1} + ${n2} = ${result} - odd`);
        }
    }else if(op=="-"){
        result= n1-n2;
        if(result%2==0){
            console.log(`${n1} - ${n2} = ${result} - even`);
        }else{
            console.log(`${n1} - ${n2} = ${result} - odd`);
        }    
    }else if(op=="*"){
        result= n1*n2;
        if(result%2==0){
            console.log(`${n1} * ${n2} = ${result} - even`);
        }else{
            console.log(`${n1} * ${n2} = ${result} - odd`);
        }    
    }else if(op=="/"){
        if(n2==0){
            console.log(`Cannot divide ${n1} by zero`);
            return;
        }
        result= (n1/n2).toFixed(2);
        console.log(`${n1} / ${n2} = ${result}`);

    }else if(op=="%"){
        if(n2==0){
            console.log(`Cannot divide ${n1} by zero`);
            return;
        }
        result= n1%n2;
        console.log(`${n1} % ${n2} = ${result}`);

    }
}