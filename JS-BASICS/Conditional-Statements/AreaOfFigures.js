function isExcelent(input){
    let figureType = input[0];
    let area = 0;
    switch(figureType){
        case "square":{
            let size = Number(input[1]);
            area = size*size;
            break;
        }
        case "rectangle":{
            let a = Number(input[1]);
            let b = Number(input[2]);
            area = a*b;
            break;
        }
        case  "circle":{
            let radius = input[1];
            area = radius*radius*Math.PI;
            break;
        }
        case "triangle":{
            let width = Number(input[1]);
            let height = Number(input[2]);
            area = width*height/2;
            break;
        }
     }
    
    console.log(area.toFixed(3));
}
