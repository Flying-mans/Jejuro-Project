const ctx = document.getElementById('myChart').getContext('2d');
const myChart = new Chart(ctx, {
	type: 'bar',
	data: {
		labels: ['1일', '2일', '3일', '4일', '5일', '6일', '7일', '8일', '9일', '10일','11일','12일','13일','14일','15일'],
		datasets: [{
			label: '아시아나',
			data: [45000,
				48000,
				46000,
				49000,
				50000,
				47000,
				48000,
				49000,
				50000,
				47000,
				48000,
				45000,
				48000,
				48000,
				50000,
			],
			backgroundColor: [
				'rgba(255, 99, 132, 0.2)',
				// 'rgba(54, 162, 235, 0.2)',
				// 'rgba(255, 206, 86, 0.2)',
				// 'rgba(75, 192, 192, 0.2)',
				// 'rgba(153, 102, 255, 0.2)',
				// 'rgba(255, 159, 64, 0.2)'
			],
			borderColor: [
				'rgba(255, 99, 132, 1)',
				// 'rgba(54, 162, 235, 1)',
				// 'rgba(255, 206, 86, 1)',
				// 'rgba(75, 192, 192, 1)',
				// 'rgba(153, 102, 255, 1)',
				// 'rgba(255, 159, 64, 1)'
			],
			borderWidth: 1
		}]
	},
	options: {
		responsive: false,}
});