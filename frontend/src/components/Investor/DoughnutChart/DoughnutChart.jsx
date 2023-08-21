import React from 'react';
import {
    Chart as ChartJS,
    ArcElement,
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    Title,
    Tooltip,
    Legend,
} from 'chart.js';
import { Doughnut } from 'react-chartjs-2';

ChartJS.register(
    ArcElement,
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    Title,
    Tooltip,
    Legend
);

const DoughnutChart = ({data}) => {

    const labels = data.map(item => item.fundName);
    const values = data.map(item => item.units);

    const chartData = {
        labels: labels,
        datasets: [
            {
                data: values,
                backgroundColor: [
                    '#36A2EB',
                    '#851e3e',
                    '#FFCE56',
                    '#4CAF50',
                    '#FF6384',
                    '#E91E63',
                    // ...add more colors as needed
                ],
                hoverBackgroundColor: [
                    '#36A2EB',
                    '#851e3e',
                    '#FFCE56',
                    '#4CAF50',
                    '#FF6384',
                    '#E91E63',

                    // ...add more colors as needed
                ],
            },
        ],
    };

    return (
        <Doughnut
            data={chartData}
            options={{
                responsive: true,
            }}
        />
    );
};

export default DoughnutChart;
