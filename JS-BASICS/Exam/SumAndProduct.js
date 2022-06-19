function exam(input){
    let n = Number(input.shift());

    if(n<100 || n>1000){
        return;
    }

    for (let a = 1; a <9; a++) {
        for (let b = 9; b> a; b--) {        
            for (let c = 0; c <9; c++) {        
                for (let d = 9; d >c; d--) {
                    let sum = a+b+c+d;
                    let multiplication = a*b*c*d; 

                    if(sum == multiplication && n%10==5){
                        console.log(`${a}${b}${c}${d}`);
                        return;
                    }else if(Math.floor(multiplication/sum) == 3 && n%3==0){
                        console.log(`${d}${c}${b}${a}`);
                        return;
                    }
                }   
            }
        }     
    }

    console.log("Nothing found")
}

exam([0]);