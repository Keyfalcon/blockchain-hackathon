pragma solidity ^0.4.2;
contract Transfer {

    enum Status{
        ASSET_CREATED
    }

    struct Record{
        address sender;
        address receiver;
        uint creationDate;
        uint departureDate;
        Status status;
        uint quantity;
        bytes32 receiverHash;
    }

    mapping(address => Record) public record;
}
