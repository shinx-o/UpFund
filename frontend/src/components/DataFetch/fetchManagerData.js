import axios from "axios";


export const getAllMutualFunds = async () => {
    try {
        const response = await axios.get('http://localhost:5000/mutualfunds');
        return response.data;
    } catch (err) {
        console.error(err);
    }
}

export const getMutualFund = async (mutualFundId) => {
    try {
        const response = await axios.get('http://localhost:5000/mutualfunds/'+ mutualFundId);
        return response.data;
    } catch (err) {
        console.error(err);
    }
}

export const getAllStocks = async () => {
    try {
        const response = await axios.get('http://localhost:5000/stocks');
        return response.data;
    } catch (err) {
        console.error(err);
    }
}
export const createMutualFund = async (data) => {
    try {
        console.log(data)
        const response = await axios({
            method: "POST",
            url: "http://localhost:5000/mutualfunds/create",
            data: data
        })
        console.log(response)
        return true;
    } catch (err) {
        console.error(err);
    }
}

