function calculateSales(){
    let projectionType = calculateSales[0];
    let rows = Number(calculateSales[1]);
    let cols = Number(calculateSales[2]);

    let sales = 0;

    if(projectionType=="Premiere"){
        sales = rows*cols*12.0;
    }else if(projectionType=="Normal"){
        sales = rows*cols*7.6;
    }else if(projectionType=="Discount"){
        sales = rows*cols*5.0;
    }

    console.log(`${sales.toFixed(2)} leva`);
}
calculateSales(["Premiere",
"10",
"12"]);
