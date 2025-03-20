#include <iostream>
#include <string>
#include <vector>

using namespace std;

vector<int> roomPrices = {100, 200, 300, 400, 500}; // Initial Prices

// Function to update price based on demand
int calculatePrice(int roomId, int demandFactor)
{
    int newPrice = roomPrices[roomId] + (demandFactor * 10);
    roomPrices[roomId] = newPrice; // Update stored price
    return newPrice;
}

int main(int argc, char *argv[])
{
    if (argc < 3)
    {
        cout << "Error: Room ID and demand factor required!" << endl;
        return 1;
    }

    int roomId = stoi(argv[1]);
    int demandFactor = stoi(argv[2]);

    int updatedPrice = calculatePrice(roomId, demandFactor);
    cout << updatedPrice << endl; // Output new price
    return 0;
}
