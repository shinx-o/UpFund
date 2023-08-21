import React from 'react';
import { Bar } from 'react-chartjs-2';
import {
    Chart as ChartJS,
    CategoryScale,
    LinearScale,
    BarElement,
    Title,
    Tooltip,
    Legend,
} from 'chart.js';

ChartJS.register(
    CategoryScale,
    LinearScale,
    BarElement,
    Title,
    Tooltip,
    Legend
);

const BarChart = ({ data }) => {

    const chartData = {
        labels: data.map(item => item.mutualFundName),

        datasets: [
            {
                label: 'Net Asset Value History',
                data: data.map(item => item.currentNav),
                backgroundColor: '#9AD0F5', // Bar color
                borderColor: '#36A2EB', // Border color
                borderWidth: 1,
            },
        ],
    };

    const options = {
        scales: {
            y: {
                beginAtZero: true,
            },
        },
    };

    return (
        <div className="bar-chart" style={{ width: '100%', height: '100%' }}>
            <Bar data={chartData} options={options} />
        </div>
    );
};

export default BarChart;
