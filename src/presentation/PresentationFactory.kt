package presentation

import domain.utils.Formatter

interface PresentationFactory<T> {
    fun getPresentationFormat(format: PresentationFormat): Formatter<T>
}