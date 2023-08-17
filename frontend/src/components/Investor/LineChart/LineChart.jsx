import React, { useState } from 'react';
import {
    Chart as ChartJS,
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    Title,
    Tooltip,
    Legend,
} from 'chart.js';
import { Line } from 'react-chartjs-2';

ChartJS.register(
    CategoryScale,
    LinearScale,
    PointElement,
    LineElement,
    Title,
    Tooltip,
    Legend
);

export const options = {
    responsive: true,
    plugins: {
        legend: {
            position: 'bottom',
            display: true
        },
        title: {
            display: true,
            text: 'Chart.js Line Chart',
        },
    },

};

const labels = ["17 Aug", "18 Aug", "19 Aug", "20 Aug", "21 Aug", "22 Aug", "23 Aug", "24 Aug", "25 Aug", "26 Aug"]
    ;

export const data = {
    labels,
    datasets: [
        {
            label: 'Growth Fund',
            data: [256, 731, 873, 114, 631, 974, 88, 418, 679, 527, 404, 189, 501, 827, 302, 689, 153, 975, 586, 68],
            borderColor: 'rgb(255, 99, 132)',
            backgroundColor: 'rgba(255, 99, 132, 0.5)',
        },
        {
            label: 'Value Fund',
            data: [398, 243, 522, 789, 673, 222, 401, 510, 343, 201, 593, 835, 127, 339, 701, 456, 981, 507, 654, 124],
            borderColor: 'rgb(75, 192, 192)',
            backgroundColor: 'rgba(75, 192, 192, 0.5)',
        },
        {
            label: 'Income Fund',
            data: [587, 329, 161, 876, 450, 742, 989, 601, 280, 157, 847, 380, 665, 915, 758, 291, 583, 139, 426, 932],
            borderColor: 'rgb(255, 205, 86)',
            backgroundColor: 'rgba(255, 205, 86, 0.5)',
        },
        {
            label: 'Equity Fund',
            data: [846, 507, 224, 981, 374, 648, 109, 505, 786, 420, 130, 580, 296, 695, 874, 253, 712, 938, 610, 157],
            borderColor: 'rgb(54, 162, 235)',
            backgroundColor: 'rgba(54, 162, 235, 0.5)',
        },
        {
            label: 'Bond Fund',
            data: [316, 741, 472, 829, 953, 198, 507, 660, 410, 832, 675, 248, 579, 134, 917, 305, 711, 593, 825, 490],
            borderColor: 'rgb(153, 102, 255)',
            backgroundColor: 'rgba(153, 102, 255, 0.5)',
        },
    ],
};

const LineChart = () => {
    const [activeDataset, setActiveDataset] = useState(null);

    const handleDatasetClick = (event, activeElements, chart) => {
        if (activeElements.length > 0) {
            const clickedDatasetIndex = activeElements[0].datasetIndex;
            if (activeDataset === clickedDatasetIndex) {
                // If the same dataset is clicked again, reset to show all datasets
                setActiveDataset(null);
            } else {
                // Otherwise, set the clicked dataset as active
                setActiveDataset(clickedDatasetIndex);
            }
        } else {
            // Clicking on the empty area resets to show all datasets
            setActiveDataset(null);
        }
    };
    const filteredDatasets = activeDataset !== null ? [data.datasets[activeDataset]] : data.datasets;


    const options = {
        scales: {
            y: {
                beginAtZero: true,
            },
        },
        onClick: handleDatasetClick,

    };

    return (
        <div>
            <Line data={{ ...data, datasets: filteredDatasets }} options={options} />
        </div>
    );
};

export default LineChart;
