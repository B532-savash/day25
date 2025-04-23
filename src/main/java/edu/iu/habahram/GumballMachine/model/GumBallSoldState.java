package edu.iu.habahram.GumballMachine.model;

public class GumBallSoldState implements IState {
    IGumballMachine gumballMachine;

    public GumBallSoldState(IGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public TransitionResult insertQuarter() {
        return new TransitionResult(false, "Please wait, we’re already giving you a gumball", gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult ejectQuarter() {
        return new TransitionResult(false, "You already turned the crank", gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult turnCrank() {
        return new TransitionResult(false, "Turning twice doesn't get you another gumball", gumballMachine.getTheStateName(), gumballMachine.getCount());
    }

    @Override
    public TransitionResult dispense() {
        gumballMachine.releaseBall();
        int count = gumballMachine.getCount();
        if (count > 0) {
            gumballMachine.changeTheStateTo(GumballMachineState.NO_QUARTER);
        } else {
            gumballMachine.changeTheStateTo(GumballMachineState.OUT_OF_GUMBALLS);
        }
        return new TransitionResult(true, "A gumball comes rolling out the slot...", gumballMachine.getTheStateName(), count);
    }

    @Override
    public String getTheName() {
        return GumballMachineState.GUMBALL_SOLD.name();
    }
}
