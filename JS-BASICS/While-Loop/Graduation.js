function graduation(input){
    let gradesSum = 0;
    let name = input[0];
    let badGrade = 0;
    let counter = 1;

    while(counter<=12){
        let grade = Number(input[counter]);

        if (grade<4) {
            badGrade++;
            if (badGrade==2) {
                console.log(`${name} has been excluded at ${counter} grade`);
                return;
            }
            continue;
        }

        if (badGrade==2) {
            console.log(`${name} has been excluded at ${counter} grade`);
            return;
        }
        gradesSum+=grade;
        counter++;
    }

    console.log(`${name} graduated. Average grade: ${(gradesSum/12).toFixed(2)}`);
}

graduation(["Mimi", 
"5",
"6",
"5",
"6",
"5",
"6",
"6",
"2",
"3"]);
