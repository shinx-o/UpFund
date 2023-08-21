import axios from "axios";


export const getAllMutualFunds = async () => {
    try {
        const response = await axios.get('http://localhost:5000/mutualfunds');
        console.log(response.data);
        return response.data;
    } catch (err) {
        console.error(err);
    }
}

export const getAllStocks = async () => {
    try {
        const response = await axios.get('http://localhost:5000/stocks');
        console.log(response.data);
        return response.data;
    } catch (err) {
        console.error(err);
    }
}

