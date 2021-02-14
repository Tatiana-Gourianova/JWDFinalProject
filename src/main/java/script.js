let canvas = document.getElementById('canv');
let ctx = canvas.getContext('2d');

let x1 = 200;
let y1 = 200;
let x2 = 800;
let y2 = 200;
let x3 = 500;
let y3 = 700;

let k = 0;
let iterations = 5;
let input = document.getElementById('iters');
input.value = iterations;
input.onchange = (e) => {
	iterations = input.value;
	console.log(iterations);
}

document.getElementById('iterations').onsubmit = (e) => {
	e.preventDefault();
	draw();
}




function koh(x1, y1, x2, y2, k, i){

	let x3 = x1 + (x2 - x1) / 3;
	let y3 = y1 + (y2 - y1) / 3;
	let x4 = x1 + 2 * (x2 - x1) / 3;
	let y4 = y1 + 2 * (y2 - y1) / 3;

	ctx.beginPath();
	ctx.strokeStyle = 'rgba(255, 255, 255, 1)';
	ctx.moveTo(x3, y3);
	ctx.lineTo(x4, y4);	
	ctx.stroke();
	

	let l = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
	let h = l / (2 * Math.sqrt(3));

	let sina = (y2 - y1) / l;
    let cosa = (x2 - x1) / l;

    let x5 = (x2 + x1) / 2 + h * i * sina;
    let y5 = (y2 + y1) / 2 - h * i* cosa;

    ctx.beginPath();
    ctx.strokeStyle = 'black';
    ctx.moveTo(x3, y3);
    ctx.lineTo(x5, y5);
    ctx.lineTo(x4, y4);
	ctx.stroke();

    k++;
    if(k < iterations){
    	koh(x1, y1, x3, y3, k, i);
    	koh(x3, y3, x5, y5, k, i);
    	koh(x5, y5, x4, y4, k, i);
    	koh(x4, y4, x2, y2, k, i);
    }
}


function draw(){
	ctx.clearRect(0, 0, canvas.width, canvas.height);
	ctx.beginPath();
	ctx.moveTo(x1, y1);
	ctx.lineTo(x2, y2);
	ctx.lineTo(x3, y3)
	ctx.lineTo(x1, y1);
	ctx.stroke();

	koh(x1, y1, x2, y2, k, 1);
	koh(x3, y3, x2, y2, k, -1);	
	koh(x1, y1, x3, y3, k, -1);
};

draw();

	
