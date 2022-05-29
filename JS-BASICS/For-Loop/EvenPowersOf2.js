function evenPowerOF2(input){
    let n = Number(input[0]);
    for (let index = 0; index <=n; index+=2) {
        console.log(Math.pow(2,index));        
    }
}