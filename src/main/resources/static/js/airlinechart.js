const ctx = document.getElementById('myChart').getContext('2d');
const myChart = new Chart(ctx, {
	type: 'line',
	data: {
		labels: ['12,21', '12,22', '3일', '4일', '5일', '6일', '7일', '8일', '9일', '10일','11일','12일','13일','14일','15일'],
		datasets: [{
			label: '아시아나',
			data: [127400,
				126400,
				140400,
				140400,
				140400,
				127400,
				137400,
				126400,
				126900,
				137400,
				90400,
				89400,
				92400,
				109400,
				86000,
			],
			backgroundColor: [
				'rgba(255, 153, 0, 0.3)',
			],
			borderColor: [
				'rgba(255, 153, 0, 1)',
			],
			borderWidth: 1
		}]
	},
	options: {
		responsive: false,
		scales: {
		yAxes: [{
			ticks: {
				min: 10000,
				max: 200000,
				stepSize : 10000,
				fontSize : 15,
			}
		}]
	}}
});
