package com.manager.services;

public class MutualFundService {
	private Map<Integer, MutualFund> mutualFunds = new HashMap<>();
    private Map<String, Integer> nameToIdMap = new HashMap<>();

    public String createMutualFund(MutualFund mutualFund) {
        mutualFunds.put(mutualFund.getId(), mutualFund);
        nameToIdMap.put(mutualFund.getName(), mutualFund.getId());
        return "Mutual Fund created successfully!";
    }

    public String getAllMutualFund() {
        return mutualFunds.values().toString();
    }

    public String getMutualFundById(int mId) {
        MutualFund mutualFund = mutualFunds.get(mId);
        return mutualFund != null ? mutualFund.toString() : "Mutual Fund not found.";
    }

    public String getMutualFundByName(String name) {
        Integer mutualFundId = nameToIdMap.get(name);
        MutualFund mutualFund = mutualFunds.get(mutualFundId);
        return mutualFund != null ? mutualFund.toString() : "Mutual Fund not found.";
    }

    public String updateMutualFundByIdCompletely(MutualFund mutualFund, int mId) {
        if (!mutualFunds.containsKey(mId)) {
            return "Mutual Fund not found.";
        }
        mutualFunds.put(mId, mutualFund);
        return "Mutual Fund completely updated by ID successfully!";
    }

    public String updateMutualFundByNameCompletely(MutualFund mutualFund, String name) {
        Integer mutualFundId = nameToIdMap.get(name);
        if (mutualFundId == null) {
            return "Mutual Fund not found.";
        }
        mutualFunds.put(mutualFundId, mutualFund);
        return "Mutual Fund completely updated by name successfully!";
    }

    public String updateMutualFundById(MutualFund mutualFund, int mId) {
        if (!mutualFunds.containsKey(mId)) {
            return "Mutual Fund not found.";
        }
        MutualFund existingMutualFund = mutualFunds.get(mId);
        existingMutualFund.setName(mutualFund.getName());
        existingMutualFund.setType(mutualFund.getType());
        existingMutualFund.setUnits(mutualFund.getUnits());
        existingMutualFund.setAmount(mutualFund.getAmount());
        existingMutualFund.setDate(mutualFund.getDate());
        return "Mutual Fund partially updated by ID successfully!";
    }

    public String updateMutualFundByName(MutualFund mutualFund, String name) {
        Integer mutualFundId = nameToIdMap.get(name);
        if (mutualFundId == null) {
            return "Mutual Fund not found.";
        }
        MutualFund existingMutualFund = mutualFunds.get(mutualFundId);
        existingMutualFund.setType(mutualFund.getType());
        existingMutualFund.setUnits(mutualFund.getUnits());
        existingMutualFund.setAmount(mutualFund.getAmount());
        existingMutualFund.setDate(mutualFund.getDate());
        return "Mutual Fund partially updated by name successfully!";
    }
}
