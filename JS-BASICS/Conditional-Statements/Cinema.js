function calculateSalesin(input){
    let projectionType = input[0];
    let rows = Number(input[1]);
    let cols = Number(input[2]);

    let sales = 0;

    if(projectionType=="Premiere"){
        sales = rows*cols*12.0;
    }else if(projectionType=="Normal"){
        sales = rows*cols*7.5;
    }else if(projectionType=="Discount"){
        sales = rows*cols*5.0;
    }

    console.log(`${sales.toFixed(2)} leva`);
}
