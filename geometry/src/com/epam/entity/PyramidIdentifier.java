package com.epam.entity;


public class PyramidIdentifier extends Pyramid {
    private final long identifier;

    public PyramidIdentifier(Point a, Point b, Point c, Point d, Point o, long identifier) {
        super(a, b, c, d, o);
        this.identifier = identifier;
    }

    public long getIdentifier() {
        return identifier;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        PyramidIdentifier pyramidObj = (PyramidIdentifier) obj;
        return this.identifier == pyramidObj.identifier;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = (int) (37 * result * identifier);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + " ID:" + identifier;
    }

}
