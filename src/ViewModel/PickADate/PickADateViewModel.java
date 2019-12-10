package ViewModel.PickADate;

import Model.BookingClientInterface;

public class PickADateViewModel {

    private BookingClientInterface bookingClient;
    public PickADateViewModel(BookingClientInterface bookingClient) {
        this.bookingClient= bookingClient;
    }

}
