function solve([age,p1, p2]) {
 
    age=parseInt(age);
    p1=Number(p1);
    p2=parseInt(p2);
 
    let toycount=Number(0.0);
    let moneycount=Number(0.0);
 
    for (let i=Number(0); i<=age; i++) {
        if (i%2==1) {
            toycount++;
        } else if (i%2==0 && i>0) {
            moneycount=moneycount-1+i*5;
        }
    }
    moneycount+=toycount*p2;
 
    if (moneycount>=p1) {
        let diff=(moneycount-p1).toFixed(2);
        console.log(`Yes! ${diff}`)
    } else {
        let diff=(p1-moneycount).toFixed(2);
        console.log(`No! ${diff}`)
    }
}